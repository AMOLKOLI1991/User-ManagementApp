package com.bikkadit.usermanagement.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bikkadit.usermanagement.bindings.LoginForm;
import com.bikkadit.usermanagement.bindings.UnlockAccountForm;
import com.bikkadit.usermanagement.bindings.UserForm;
import com.bikkadit.usermanagement.entities.City;
import com.bikkadit.usermanagement.entities.Country;
import com.bikkadit.usermanagement.entities.States;
import com.bikkadit.usermanagement.entities.UserAccount;
import com.bikkadit.usermanagement.repository.CityRepository;
import com.bikkadit.usermanagement.repository.CountryRepository;
import com.bikkadit.usermanagement.repository.StatesRepository;
import com.bikkadit.usermanagement.repository.UserAccountRepository;
import com.bikkadit.usermanagement.util.EmailUtil;

import net.bytebuddy.utility.RandomString;

@Service
public class UserServiceImpl implements UserServiceI {

	@Autowired
	private UserAccountRepository userAccountRepository;

	@Autowired
	private CountryRepository countryRepository;

	@Autowired
	private StatesRepository statesRepository;

	@Autowired
	private CityRepository cityRepository;

	@Autowired
	private EmailUtil emailUtil;

	@Override
	public String loginCheck(LoginForm loginform) {
		UserAccount user = userAccountRepository.findByUserEmailAndUserPassword(loginform.getUserEmail(),
				loginform.getUserPassword());
		if (user != null) {
			String accStatus = user.getAccStatus();
			if (accStatus.equals("LOCKED")) {
				return "Your Account is locked";
			} else {
				return "login success";
			}
		}
		return "Invalid Credentials";
	}

	@Override
	public Map<Integer, String> getContries() {
		List<Country> contries = countryRepository.findAll();
		Map<Integer, String> mapContries = new HashMap<Integer, String>();
		contries.forEach(country -> {
			mapContries.put(country.getCountryId(), country.getCountryName());
		});
		return mapContries;
	}

	@Override
	public Map<Integer, String> getStates(Integer countryId) {
		List<States> state = statesRepository.findByCountryId(countryId);
		Map<Integer, String> mapStates = new HashMap<>();
		state.forEach(States -> {
			mapStates.put(States.getStateId(), States.getStateName());
		});
		return mapStates;
	}

	@Override
	public Map<Integer, String> getCities(Integer stateId) {
		List<City> cities = cityRepository.findByStateId(stateId);
		Map<Integer, String> mapCities = new HashMap<>();
		cities.forEach(City -> {
			mapCities.put(City.getCityId(), City.getCityName());
		});
		return mapCities;
	}

	@Override
	public boolean emailUnique(String email) {
		UserAccount user = userAccountRepository.findByUserEmail(email);
		if (user == null) {
			return true;
		}
		return false;
	}

	@Override
	public boolean saveUser(UserForm userForm) {
		UserAccount userAccount = new UserAccount();
		userForm.setAccStatus("LOCKED");
		userForm.setUserPassword(generateTempPwd());
		BeanUtils.copyProperties(userForm, userAccount);
		UserAccount save = userAccountRepository.save(userAccount);
		String subject = "Your Registration Successful";
		String body = getUserEmailBody(userForm);
		if (save.getUserId() != null) {
			try {
				emailUtil.sendMail(userForm.getUserEmail(), subject, body);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return true;
		} else {
			return false;
		}

	}

	@Override
	public boolean isTempPwsValid(String email, String tempPwd) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean unlockAccount(UnlockAccountForm unlockAccountForm) {
		String userEmail = unlockAccountForm.getUserEmail();
		String tempPwd = unlockAccountForm.getTempPwd();
		UserAccount userAccount = userAccountRepository.findByUserEmailAndUserPassword(userEmail, tempPwd);
		if (userAccount != null) {
			userAccount.setAccStatus("UNLOCKED");
			userAccount.setUserPassword(unlockAccountForm.getNewPwd());
			userAccountRepository.save(userAccount);
			return true;
		}
		return false;
	}

	@Override
	public String forgotPwd(String emailId) {
		UserAccount userEmail = userAccountRepository.findByUserEmail(emailId);
		if (userEmail != null) {
			String subject = "Forgot Password Sent";
			String Body = getForgotEmailBody(userEmail);
			try {
				emailUtil.sendMail(emailId, subject, Body);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return "SUCCESS";
		}
		return "FAIL";
	}

	private String generateTempPwd() {
		String tempPwd = RandomStringUtils.randomAlphanumeric(8);
		return tempPwd;
	}

	
	private String getUserEmailBody(UserForm userForm) {
		StringBuffer sb = new StringBuffer();
		String fileName = "UNLOCK-ACCOUNT.txt";
		List<String> lines = new ArrayList<>();

		try {
			BufferedReader br = Files.newBufferedReader(Paths.get(fileName));
			lines = br.lines().collect(Collectors.toList());
		} catch (IOException e) {

			e.printStackTrace();
		}

		lines.forEach(line -> {
			if (line.contains("{FNAME}")) {
				line.replace("{FNAME}", userForm.getUserFirstName());
			}
			if (line.contains("{LNAME}")) {
				line.replace("{LNAME}", userForm.getUserLastName());
			}
			if (line.contains("{TEMP-PWD}")) {
				line.replace("{TEMP-PWD}", userForm.getUserPassword());
			}
			if (line.contains("{EMAIL}")) {
				line.replace("{EMAIL}", userForm.getUserEmail());
			}

			sb.append(line);

		});

		return sb.toString();

	}

	private String getForgotEmailBody(UserAccount userAccount) {
		StringBuffer sb = new StringBuffer();
		String fileName = "FORGOT-PASSWORD.txt";
		List<String> lines = new ArrayList<>();

		try {
			BufferedReader br = Files.newBufferedReader(Paths.get(fileName));
			lines = br.lines().collect(Collectors.toList());
		} catch (IOException e) {

			e.printStackTrace();
		}

		lines.forEach(line -> {
			if (line.contains("{FNAME}")) {
				line.replace("{FNAME}", userAccount.getUserFirstName());
			}
			if (line.contains("{LNAME}")) {
				line.replace("{LNAME}", userAccount.getUserLastName());
			}
			if (line.contains("{PWD}")) {
				line.replace("{PWD}", userAccount.getUserPassword());
			}

			sb.append(line);

		});

		return sb.toString();

	}

	
	
	
}

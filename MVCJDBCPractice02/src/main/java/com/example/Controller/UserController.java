package com.example.Controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.DAO.UserDao;
import com.example.POJO.User;

@Controller
public class UserController {

	private final UserDao dao;

	public UserController(UserDao dao) {
		this.dao = dao;
	}

	@GetMapping("/form")
	public String showForm() {
		return "user-form";
	}

	@PostMapping("/save")
	public String insertUser(@RequestParam("name") String name, @RequestParam("email") String email) {

		User user = new User();
		user.setName(name);
		user.setEmail(email);
		dao.insertUser(user);

		return "redirect:/list";
	}

	@GetMapping("/list")
	public String listUsers(Model model) {
		List<User> users = dao.displayUsers();
		model.addAttribute("users", users);
		return "user-list";
	}

}

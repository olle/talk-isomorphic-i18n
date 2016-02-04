package talks.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import talks.messages.MessageService;

@Controller
class Index {

	private final MessageService messageService;

	@Autowired
	public Index(MessageService messageService) {
		this.messageService = messageService;
	}

	@RequestMapping("/")
	public String index(Model model) {

		model.addAttribute("greeting", messageService.getMessage("greeting"));

		return "index";
	}
}

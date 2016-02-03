package talks.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
class Index {

	private final MessageSource messages;

	@Autowired
	public Index(MessageSource messages) {
		this.messages = messages;
	}

	@RequestMapping("/")
	public String index(Model model) {

		model.addAttribute("greeting", messages.getMessage("greeting", null, LocaleContextHolder.getLocale()));

		return "index";
	}
}

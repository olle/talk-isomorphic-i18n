package talks.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class Js {

	@RequestMapping(value = "i18n.js", produces = { "application/javascript" })
	@ResponseBody
	public String i18n() {

		return "{}";
	}
}

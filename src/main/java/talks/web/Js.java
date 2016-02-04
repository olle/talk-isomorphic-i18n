package talks.web;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializerProvider;

import talks.messages.MessageService;

@Controller
public class Js {

	private final MessageService messageService;
	private final ObjectMapper objectMapper;

	@Autowired
	public Js(MessageService messageService, ObjectMapper objectMapper) {
		this.messageService = messageService;
		this.objectMapper = objectMapper;
	}

	@RequestMapping(value = "/i18n.js", produces = { "application/javascript" })
	@ResponseBody
	public String i18n() throws JsonProcessingException {

		objectMapper.getSerializerProvider().setNullKeySerializer(new JsonSerializer<Object>() {

			@Override
			public void serialize(Object value, JsonGenerator gen, SerializerProvider serializers)
					throws IOException, JsonProcessingException {
				gen.writeFieldName("default");
			}

		});

		return "var i18n = " + objectMapper.writeValueAsString(messageService.getMessages())
				+ "; i18n.getMessage = function (key) { return (i18n[navigator.language.split('-')[0]] || i18n.default)[key]; }";
	}
}

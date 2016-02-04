package talks.messages;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Service;

@Service
public class Simple implements MessageService {

	private final MessageSource messages;

	@Autowired
	public Simple(MessageSource messages) {

		this.messages = messages;
	}

	@Override
	public String getMessage(String key) {

		return messages.getMessage(key, null, LocaleContextHolder.getLocale());
	}

}

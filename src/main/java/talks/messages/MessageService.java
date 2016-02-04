package talks.messages;

import java.util.Locale;
import java.util.Map;

public interface MessageService {

	String getMessage(String key);

	Map<Locale, Map<String, String>> getMessages();

}

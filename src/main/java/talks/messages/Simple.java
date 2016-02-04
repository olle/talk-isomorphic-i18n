package talks.messages;

import java.io.IOException;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Properties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.ResourcePatternResolver;
import org.springframework.stereotype.Service;

@Service
public class Simple implements MessageService {

	private final MessageSource messages;
	private final ResourcePatternResolver resourcePatternResolver;

	@Autowired
	public Simple(MessageSource messages, ResourcePatternResolver resourcePatternResolver) {

		this.messages = messages;
		this.resourcePatternResolver = resourcePatternResolver;
	}

	@Override
	public String getMessage(String key) {

		return messages.getMessage(key, null, LocaleContextHolder.getLocale());
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public Map<Locale, Map<String, String>> getMessages() {

		try {

			Map<Locale, Map<String, String>> results = new HashMap<>();

			Resource[] resources = resourcePatternResolver
					.getResources(ResourcePatternResolver.CLASSPATH_URL_PREFIX + "messages*.properties");

			for (Resource r : resources) {

				final Locale locale;
				final Map<String, String> messages;

				{
					String lang = r.getFilename().replace("messages", "").replace(".properties", "");

					if (lang.length() == 0) {
						locale = null;
					} else {
						locale = new Locale(lang.replace("_", ""));
					}
				}

				{
					Properties properties = new Properties();
					properties.load(r.getInputStream());

					messages = new HashMap(properties);
				}

				results.put(locale, messages);
			}

			return results;

		} catch (IOException e) {
			throw new RuntimeException("Unable to get messages", e);
		}
	}

}

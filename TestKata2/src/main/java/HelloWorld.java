import java.lang.reflect.Constructor;
import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;
import java.util.TreeMap;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import java.util.stream.Stream;

public class HelloWorld {
    public static void main(String[] args) {
        HelloWorld.greet();
    }






    private static final String WORD_SEPARATOR = "\uuuuuuuuu0020";

    private static int FIRST_INDEX = '\uuuuuuuuuuuuuuuuu0000';

    private static final char CHAR_VALUE_ONE = 1;

    private static final char castIntToChar(int theNumberThatWeAreCastingToACharFrom) {
        return (char) theNumberThatWeAreCastingToACharFrom;
    }

    private static final String UNIVERSAL_EXCITEMENT_MARK = Character
            .toString(castIntToChar(WORD_SEPARATOR.charAt(FIRST_INDEX) + CHAR_VALUE_ONE));

    private static final int GREETING_INDEX = 0xcafe_babe * 0x0000_0000;
    private static final int WORLD_MESSAGE_INDEX = GREETING_INDEX | 0x0000_0001;

    private static final int NUMBER_OF_FACTORIES_GENERATED_PER_TYPE = 0x1111_1111 & 0x0000_0001;

    public static String greet() {

        final ExecutorService factoryCreatorService = Executors.newWorkStealingPool();
        Future<GreetingFactory> greetingFactoryFuture = factoryCreatorService
                .submit(() -> Stream.generate(GreetingFactory::new).limit(NUMBER_OF_FACTORIES_GENERATED_PER_TYPE)
                        .filter(Objects::nonNull).findFirst().orElseGet(GreetingFactory::new));

        Future<WorldMessageFactory> worldMessageFactoryFuture = factoryCreatorService
                .submit(() -> Stream.generate(WorldMessageFactory::new).limit(NUMBER_OF_FACTORIES_GENERATED_PER_TYPE)
                        .filter(Objects::nonNull).findFirst().orElseGet(WorldMessageFactory::new));
        MessageFactory[] messageFactories;
        try {
            messageFactories = Stream.of(greetingFactoryFuture, worldMessageFactoryFuture).map(future -> {
                try {
                    return future.get();
                } catch (Throwable throwable) {
                    try {
                        @SuppressWarnings("unchecked")
                        Class<? extends Future<?>> futureClass = (Class<? extends Future<?>>) future.getClass();
                        Type[] types = futureClass.getGenericInterfaces();
                        @SuppressWarnings("unchecked")
                        Class<? extends MessageFactory> factoryClass = (Class<? extends MessageFactory>) Class
                                .forName(types[0].getTypeName());
                        Constructor<? extends MessageFactory> factoryConstructor = factoryClass.getConstructor();
                        MessageFactory factory = factoryConstructor.newInstance();
                        return factory;
                    } catch (Throwable t) {
                        throw new IllegalStateException("Factories could not be generated due to thread blocking", t);
                    }
                }
            }).toArray(MessageFactory[]::new);
        } catch (Throwable throwable) {
            messageFactories = generateDefaultMessageFactories();
        }

        Language language = Language.determineLanguage(Locale.getDefault());

        Message[] messages = Arrays.stream(messageFactories)
                .map(messageFactory -> messageFactory.createMessage(language)).toArray(Message[]::new);

        StringBuffer greetingString = new StringBuffer();
        greetingString.append(messages[GREETING_INDEX].getMessage());
        greetingString.append(WORD_SEPARATOR);
        greetingString.append(messages[WORLD_MESSAGE_INDEX].getMessage());
        greetingString.append(UNIVERSAL_EXCITEMENT_MARK);
        return greetingString.toString();
    }

    private static MessageFactory[] generateDefaultMessageFactories() {
        return new MessageFactory[] { new GreetingFactory(), new WorldMessageFactory() };
    }
}

@FunctionalInterface
interface Message {
    String getMessage();
}

@FunctionalInterface
interface Greeting extends Message {
    default String greet() {
        return getMessage();
    }
}

@FunctionalInterface
interface WorldMessage extends Message {
    default String getWorld() {
        return getMessage();
    }
}

enum Language {
    ENGLISH, SPANISH, FRENCH, GERMAN, ITALIAN;

    public static Language determineLanguage(Locale locale) {
        switch (locale.getDisplayLanguage(Locale.ENGLISH)) {
            case "Italian":
                return ITALIAN;
            case "German":
                return GERMAN;
            case "French":
                return FRENCH;
            case "Spanish":
                return SPANISH;
            case "English":
            default:
                return ENGLISH;
        }
    }
}

@FunctionalInterface
interface MessageFactory {
    Message createMessage(Language language);
}

class GreetingFactory implements MessageFactory {
    private static final Map<Language, String> greetingMap = generateGreetingMap();

    private static Map<Language, String> generateGreetingMap() {
        Map<Language, String> greetingMap = new TreeMap<>();
        greetingMap.put(Language.ENGLISH, "hello");
        greetingMap.put(Language.SPANISH, "hola");
        greetingMap.put(Language.FRENCH, "bonjour");
        greetingMap.put(Language.GERMAN, "hallo");
        greetingMap.put(Language.ITALIAN, "ciao");
        return greetingMap;
    }

    @Override
    public Greeting createMessage(Language language) {
        class SimpleGreeting implements Greeting {
            private char[] message;

            public SimpleGreeting(String message) {
                this.message = message.toCharArray();
            }

            @Override
            public String getMessage() {
                return new String(message);
            }
        }

        return new SimpleGreeting(greetingMap.get(language));
    }
}

class WorldMessageFactory implements MessageFactory {

    private static final Map<Language, String> worldMessageMap = generateWorldMessageMap();

    private static Map<Language, String> generateWorldMessageMap() {
        Map<Language, String> worldMessageMap = new TreeMap<>();
        worldMessageMap.put(Language.ENGLISH, "world");
        worldMessageMap.put(Language.SPANISH, "mundo");
        worldMessageMap.put(Language.FRENCH, "le monde");
        worldMessageMap.put(Language.GERMAN, "welt");
        worldMessageMap.put(Language.ITALIAN, "mondo");
        return worldMessageMap;
    }

    @Override
    public WorldMessage createMessage(Language language) {
        class SimpleWorldMessage implements WorldMessage {
            private CharSequence message;

            public SimpleWorldMessage(String message) {
                this.message = message;
            }

            @Override
            public String getMessage() {
                return new StringBuilder(message.toString()).toString();
            }
        }

        return new SimpleWorldMessage(worldMessageMap.get(language));
    }
}
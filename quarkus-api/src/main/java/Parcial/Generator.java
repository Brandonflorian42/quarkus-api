package Parcial;
import java.security.SecureRandom;
//Version 1
public class Generator {

    // Aqui colocamos los caracteres que se pueden utilizar en las contraseñas
    private static final String LOWERCASE_CHARACTERS = "abcdefghijklmnopqrstuvwxyz";
    private static final String UPPERCASE_CHARACTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String NUMERIC_CHARACTERS = "0123456789";
    private static final String SPECIAL_CHARACTERS = "!@#$%^&*()-_+=";
    private static final String ALL_CHARACTERS = LOWERCASE_CHARACTERS + UPPERCASE_CHARACTERS + NUMERIC_CHARACTERS + SPECIAL_CHARACTERS;

    // Se va a generar los numeros aleatorio
    private static final SecureRandom random = new SecureRandom();

    // Declaramos un metodo para la contraseña aleatoria
    public static String generatePassword(int length) {
        // Asegurarse de que la longitud mínima sea de 8 caracteres
        if (length < 8) {
            length = 8;
        }

        StringBuilder password = new StringBuilder();

        // se agrega al menos un carácter de cada tipo
        password.append(getRandomCharacter(LOWERCASE_CHARACTERS));
        password.append(getRandomCharacter(UPPERCASE_CHARACTERS));
        password.append(getRandomCharacter(NUMERIC_CHARACTERS));
        password.append(getRandomCharacter(SPECIAL_CHARACTERS));

        // Generamos el resto de la contraseña
        for (int i = 4; i < length; i++) {
            password.append(getRandomCharacter(ALL_CHARACTERS));
        }

        shuffleString(password);

        return password.toString();
    }

    private static char getRandomCharacter(String characters) {
        int randomIndex = random.nextInt(characters.length());
        return characters.charAt(randomIndex);
    }

    private static void shuffleString(StringBuilder sb) {
        for (int i = sb.length() - 1; i > 0; i--) {
            int j = random.nextInt(i + 1);
            char temp = sb.charAt(i);
            sb.setCharAt(i, sb.charAt(j));
            sb.setCharAt(j, temp);
        }
    }
}

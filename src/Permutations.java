import java.util.ArrayList;
import java.util.List;

public class Permutations {
    // Método para generar todas las permutaciones
    public List<String> generatePermutations(char[] chars) {
        List<String> result = new ArrayList<>();
        permute(chars, 0, result);
        return result;
    }

    // Función recursiva para generar permutaciones
    private void permute(char[] chars, int start, List<String> result) {
        if (start == chars.length - 1) {
            result.add(new String(chars));
        } else {
            for (int i = start; i < chars.length; i++) {
                swap(chars, start, i);
                permute(chars, start + 1, result);
                swap(chars, start, i);
            }
        }
    }

    // Función para intercambiar dos caracteres en un arreglo
    private void swap(char[] chars, int i, int j) {
        char temp = chars[i];
        chars[i] = chars[j];
        chars[j] = temp;
    }
}


public class valida_CPF {
    void main () {
        String cpf = IO.readln("Digite o CPF (apenas números): ");
        if (cpf.matches("\\d{3}\\.\\d{3}\\.\\d{3}-\\d{2}")) {
            cpf = cpf.replaceAll("\\D", "");
        }
        if (!cpf.matches("\\d{11}")) {
            IO.println("CPF inválido! O CPF deve conter 11 dígitos.");
            main();
        } if (cpf.chars().distinct().count() == 1) {
            IO.println("CPF inválido! O CPF não pode conter todos os dígitos iguais.");
            main();
        }

        int[] cpfArray = new int[11];

        for (int i = 0; i < 11; i++) {
            try {
                cpfArray[i] = Integer.parseInt(String.valueOf(cpf.charAt(i)));
            } catch (NumberFormatException e) {
                IO.println("CPF inválido! O CPF deve conter apenas números.");
                main();
            }
        }
        int sum1 = 0;
        for (int i = 0; i < 9; i++) {
            sum1 += cpfArray[i] * (10 - i);
        }
        int checkDigit1 = (sum1 * 10) % 11;
        if (checkDigit1 == 10) checkDigit1 = 0;

        int sum2 = 0;
        for (int i = 0; i < 10; i++) {
            sum2 += cpfArray[i] * (11 - i);
        }
        int checkDigit2 = (sum2 * 10) % 11;
        if (checkDigit2 == 10) checkDigit2 = 0;

        if (checkDigit1 == cpfArray[9] && checkDigit2 == cpfArray[10]) {
            IO.println("CPF válido!");
            cpfArray[8] = Integer.parseInt(String.valueOf(cpf.charAt(8)));
            int regionCod = cpfArray[8];
            String regiao = switch (regionCod) {
                case 1 -> "Distrito Federal, Goiás, Mato Grosso, Mato Grosso do Sul e Tocantins";
                case 2 -> "Amazonas, Pará, Roraima, Amapá, Acre e Rondônia";
                case 3 -> "Ceará, Maranhão e Piauí";
                case 4 -> "Paraíba, Pernambuco, Alagoas e Rio Grande do Norte";
                case 5 -> "Bahia e Sergipe";
                case 6 -> "Minas Gerais";
                case 7 -> "Rio de Janeiro e Espírito Santo";
                case 8 -> "São Paulo";
                case 9 -> "Paraná e Santa Catarina";
                case 0 -> "Rio Grande do Sul";
                default -> "Código de região desconhecido";
            };
            IO.println("Região: " + regiao);
        } else {
            IO.println("CPF inválido!");
        }
    }
}

import java.util.Scanner;

public class Projeto{
    public static void main(String[] args) {
        Scanner salario = new Scanner(System.in);
        double[] salariosBruto = new double[5];
        double[] inss = new double[5];
        double[] impostosRenda = new double[5];
        double[] salariosLiquido = new double[5];

        System.out.println("Informe o primeiro Salário ");
        salariosBruto[0] = salario.nextDouble();

        System.out.println("Informe o segundo Salário ");
        salariosBruto[1] = salario.nextDouble();

        System.out.println("Informe o terceiro Salário ");
        salariosBruto[2] = salario.nextDouble();

        System.out.println("Informe o quarto Salário ");
        salariosBruto[3] = salario.nextDouble();

        System.out.println("Informe o quinto Salário ");
        salariosBruto[4] = salario.nextDouble();

        for (int i = 0; i < salariosBruto.length; i++){
            inss[i] = calculoInss(salariosBruto[i]);
            impostosRenda[i] = calculoImpostoRenda(salariosBruto[i]);
            salariosLiquido[i] = salariosBruto[i] - inss[i] - impostosRenda[i];
        }

        for (int i = 0; i < salariosBruto.length; i++){
            System.out.println("Salário Bruto " + i + ": " + String.format("%.2f", salariosBruto[i]));
            System.out.println("Quanto pagou ao INSS: " + String.format("%.2f",  inss[i]));
            System.out.println("Quanto pagou de Imposto de Renda " + String.format("%.2f", impostosRenda[i]));
            System.out.println("Salário Líquido " + String.format("%.2f", salariosLiquido[i]));
            System.out.println("--------------------------------------");
            System.out.println("");
        }
    }

    public static double calculoInss(double salarioBruto){
        double imposto = 0.0;

        if(salarioBruto <= 1212){
            imposto = salarioBruto * 7.5 / 100;
        }else if (salarioBruto >= 1212.01 && salarioBruto <= 2427.35){
            imposto = 1212 * 7.5 /100;
            imposto += (salarioBruto - 1212) * 9 / 100;
        } else if (salarioBruto >= 2427.36 && salarioBruto <= 3641.03) {
            imposto = 1212 * 7.5 /100;
            imposto += 1215.34 * 9 / 100;
            imposto += (salarioBruto - 2427.35) * 12 / 100;
        } else if (salarioBruto >= 3641.04 && salarioBruto <= 7087.22) {
            imposto = 1212 * 7.5 /100;
            imposto += 1215.34 * 9 / 100;
            imposto += 1213.67 * 12 / 100;
            imposto += (salarioBruto - 3641.03) * 14 / 100;
        }else {
            imposto = 1212 * 7.5 /100;
            imposto += 1215.34 * 9 / 100;
            imposto += 1213.67 * 12 / 100;
            imposto += 3446.18 * 14 / 100;
        }

        return imposto;
    }

    public static double calculoImpostoRenda(double salarioBruto){
        double imposto = 0.0;
        if (salarioBruto <= 1903.98){

        }else if (salarioBruto >= 1903.99 && salarioBruto <= 2826.65){
            imposto = (salarioBruto - 1903.98) * 7.5 /100;
        } else if (salarioBruto >= 2826.66 && salarioBruto <= 3751.05) {
            imposto += 922.66 * 7.5 /100;
            imposto += (salarioBruto - 2826.65) * 15 / 100;
        } else if (salarioBruto >= 3751.06 && salarioBruto <= 4664.68) {
            imposto += 922.66 * 7.5 /100;
            imposto += 924.39 * 15 /100;
            imposto += (salarioBruto - 3751.05) * 22.5 / 100;
        }else {
            imposto += 922.66 * 7.5 /100;
            imposto += 924.39 * 15 /100;
            imposto += 913.62 * 22.5 / 100;
            imposto += (salarioBruto - 4664.68) * 27.5 / 100;
        }

        return imposto;
    }
}

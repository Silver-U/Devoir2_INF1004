public class Calcul_Arithmétique
{
    public double auto(double operante1, double operante2, String operateur)
    {
        double result = 0;

        switch (operateur)
        {
            case "/" :
                result = operante1 / operante2;
                break;
            case "*" :
                result = operante1 * operante2;
                break;
            case "-" :
                result = operante1 - operante2;
                break;
            case "+" :
                result = operante1 + operante2;
                break;
        }
        return result;
    }
}




package br.com.conversor.modelos;

public class ConsultaCode {
    public String getBaseCode() {
        return baseCode;
    }

    public String getTargetCode() {
        return targetCode;
    }

    private String baseCode = "";
    private String targetCode = "";

    public void consultar(int consulta) {
        switch (consulta) {
            case 1:
                baseCode = "USD";
                targetCode = "ARS";
                break;
            case 2:
                baseCode = "ARS";
                targetCode = "USD";
                break;
            case 3:
                baseCode = "USD";
                targetCode = "BRL";
                break;
            case 4:
                baseCode = "BRL";
                targetCode = "USD";
                break;
            case 5:
                baseCode = "USD";
                targetCode = "COP";
                break;
            case 6:
                baseCode = "COP";
                targetCode = "USD";
                break;
        }
    }
}

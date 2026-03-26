public enum TamanhoPelo {
    CURTO(0.0),
    MEDIO(15.0),
    LONGO(25.0);

    private final double adicional;

    TamanhoPelo(double adicional) {
        this.adicional = adicional;
    }

    public double getAdicional() {
        return adicional;
    }
}
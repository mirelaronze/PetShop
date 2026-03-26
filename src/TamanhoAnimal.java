public enum TamanhoAnimal {

    PEQUENO(50.0, 12.0, 30.0),
    MEDIO(60.0, 18.0, 40.0),
    GRANDE(70.0, 25.0, 50.0);

    private final double precoBaseBanho;
    private final double precoHoraHotel;
    private final double precoTosa;

    TamanhoAnimal(double banho, double hotel, double tosa) {
        this.precoBaseBanho = banho;
        this.precoHoraHotel = hotel;
        this.precoTosa = tosa;
    }
    public double getPrecoBaseBanho() { return precoBaseBanho; }
    public double getPrecoHoraHotel() { return precoHoraHotel; }
    public double getPrecoTosa() { return precoTosa; }
}

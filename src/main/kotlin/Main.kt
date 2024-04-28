fun main() {
    val avtomat = Avtomat()
    while (true) {
        print("Вставьте монету 5 или 10 рублей: ")
        val coin = readln().toInt()
        avtomat.processCoin(coin)
        avtomat.dispenseWater()
        avtomat.dispenseChange()
    }
}
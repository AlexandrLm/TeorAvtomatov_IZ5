class Avtomat {
    private var currentState: String = "ожидание" // начальное состояние
    private val waterPrice = 25
    private var totalAmount = 0

    fun processCoin(coin: Int) {
        when (coin) {
            5, 10 -> {
                totalAmount += coin
                currentState = if (totalAmount >= waterPrice) {
                    if (totalAmount > waterPrice) {
                        "выдача_сдачи"
                    } else {
                        "выдача_воды"
                    }
                } else {
                    "ожидание"
                }
            }
            else -> println("Неверная монета")
        }
    }

    fun dispenseWater() {
        if (currentState == "выдача_воды") {
            println("Вода выдана!")
            totalAmount -= waterPrice
            currentState = "ожидание"
            if (totalAmount > 0) {
                println("Выдана сдача: $totalAmount руб")
                totalAmount = 0
            }
        }
    }

    fun dispenseChange() {
        if (currentState == "выдача_сдачи") {
            println("Вода выдана!")
            println("Выдана сдача: ${totalAmount - waterPrice} руб")
            currentState = "ожидание"
            totalAmount = 0
        }
    }
}

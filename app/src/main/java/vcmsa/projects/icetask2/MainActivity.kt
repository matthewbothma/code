// Step 1: Define the Common Interface
interface Payment {
    fun processPayment(): String
}

// Step 2: Implement Concrete Classes
class CreditCardPayment : Payment {
    override fun processPayment(): String {
        return "Processing credit card payment..."
    }
}

class PayPalPayment : Payment {
    override fun processPayment(): String {
        return "Processing PayPal payment..."
    }
}

class BankTransferPayment : Payment {
    override fun processPayment(): String {
        return "Processing bank transfer payment..."
    }
}

// Step 3: Create the Factory Class
class PaymentFactory {
    fun createPayment(type: String): Payment {
        return when (type.lowercase()) {
            "creditcard" -> CreditCardPayment()
            "paypal" -> PayPalPayment()
            "banktransfer" -> BankTransferPayment()
            else -> throw IllegalArgumentException("Unknown payment type: $type")
        }
    }
}

// Step 4: Implement Client Code
fun main() {
    val factory = PaymentFactory()

    val creditCard: Payment = factory.createPayment("creditcard")
    println(creditCard.processPayment())

    val paypal: Payment = factory.createPayment("paypal")
    println(paypal.processPayment())

    val bankTransfer: Payment = factory.createPayment("banktransfer")
    println(bankTransfer.processPayment())
}

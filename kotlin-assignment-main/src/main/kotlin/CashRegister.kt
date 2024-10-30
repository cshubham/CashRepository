/**
 * The CashRegister class holds the logic for performing transactions.
 *
 * @param change The change that the CashRegister is holding.
 */
private const val TAG = "Register"
class CashRegister(private val change: Change) {
    /**
     * Performs a transaction for a product/products with a certain price and a given amount.
     *
     * @param price The price of the product(s).
     * @param amountPaid The amount paid by the shopper.
     *
     * @return The change for the transaction.
     *
     * @throws TransactionException If the transaction cannot be performed.
     */
    fun performTransaction(price: Long, amountPaid: Change): Change {
        println("register total money " + change.total)
        if (amountPaid.total < price) {
            throw TransactionException("complete amunt not paid")
        }
        if (change.total < price) {
            throw TransactionException("register not have sufficient funds")
        }

        val diff = amountPaid.total - price
        if (diff == 0L) return Change.none()

        val resultMap = change.checkForChange(diff)
        if (resultMap.isEmpty()) {
            throw TransactionException("sufficient change not available")
        }

        val res = kotlin.runCatching {
            val resultDiffChange = Change()
            resultMap.forEach { (monetaryElement, count) ->
                change.remove(monetaryElement, count)
                resultDiffChange.add(monetaryElement, count)
            }
            println("check change " + resultDiffChange.total + " " + diff)
// denomination of paid amount is not given,
// so not considering updating given amount to register after giving change
// as dont want to change signature of change to handle add
   //         change.add(amountPaid, denomination)
            return resultDiffChange
        }.onFailure {
            println("failure in transaction " + it)
        }.getOrNull() ?: Change.none()


        return res
    }

    class TransactionException(message: String, cause: Throwable? = null) : Exception(message, cause)
}



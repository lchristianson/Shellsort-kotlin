class LLN(d: String, n: LLN?) {
    var data = d
    var next = n

    fun print() {
        println(data)
        next?.print()
    }

    fun ct(): Int {
        if(next == null)
            return 1
        else
            return 1 + next!!.ct()
    }

    fun mildsort(): LLN {
        if(next == null)
            return this
        var h = next!!.mildsort()
        next = h
        if(h.data > data) {
            next = h.next
            h.next = this
            return h
        } else {
            return this
        }
    }

    fun split(arr: Array<LLN?>, len: Int, wh: Int) {
        var t = wh
        if(t == len)
            t = 0
        var np: LLN? = next
        if(arr[t] != null)
            next = arr[t]
        else
            next = null
        arr[t] = this
        np?.split(arr, len, t+1)
    }

}
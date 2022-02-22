class LL {
    var head: LLN? = null

    fun ct(): Int {
        if(head == null)
            return 0
        else
            return head!!.ct()
    }

    fun add(d: String) {
        head = LLN(d, head)
    }

    fun mild(): LLN? {
        return head?.mildsort()
    }

    fun print() {
        println("******")
        head?.print()
        println("******")
    }

    fun shellsort() {
        var c = this.ct()
        if(c <= 1)
            return
        for(diff in (c-1) downTo 1) {
            var tdiff = diff
            while(tdiff % 2 == 0) {
                tdiff /= 2
            }
            while(tdiff % 3 == 0) {
                tdiff /= 3
            }
            if(tdiff > 1)
                continue
            var arr = Array<LLN?>(diff) {null}
            head!!.split(arr, diff, 0)
            var i: Int = 0
            while(i < diff) {
                arr[i] = arr[i]?.mildsort()
                i++
            }
            head = rejoin(arr, diff, (c-1+diff) % diff, null)
        }
    }

    fun rejoin(arr: Array<LLN?>, len: Int, wh: Int, l: LLN?): LLN? {
        var t = wh
        var tl = l
        if(t < 0)
            t = (len - 1)
        if(arr[t] == null)
            return tl
        var np: LLN? = null
        if(arr[t]!!.next != null) {
            np = arr[t]!!.next
            arr[t]!!.next = tl
            tl = arr[t]!!
            arr[t] = np
        } else {
            arr[t]!!.next = tl
            tl = arr[t]!!
            arr[t] = null
        }
        tl = rejoin(arr, len, --t, tl)
        return tl
    }
}
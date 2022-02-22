
fun main(){
   
    var test = LL()
    var input: String?
    while (true) {
        input = readLine()
        if(input == "")
            break
        test.add(input!!)
    }
    

    test.print()
    test.shellsort()
    test.print()

    
}
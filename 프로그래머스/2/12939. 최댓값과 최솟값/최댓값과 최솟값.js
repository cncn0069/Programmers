function solution(s) {
    //"1 2 3 4 -1 -2 -3 -4"
    //공백으로 나뉘어져있습니다.
    var answer = s.split(' ')
    var max = Math.max(...answer)
    var min = Math.min(...answer)
    
    return min + ' ' + max
}
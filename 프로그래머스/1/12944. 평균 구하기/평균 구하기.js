function solution(arr) {
    var answer = 0;
    
    let sum = 0;
    arr.forEach((element)=> sum += element)
    
    let avg = sum / arr.length
    
    return avg;
}
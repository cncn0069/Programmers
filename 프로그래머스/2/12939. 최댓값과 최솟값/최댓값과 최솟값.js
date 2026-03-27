function solution(s) {
    //둘 이상의 정수가 공백으로 구분
    var answer = '';
    
    //str 길이가 1이면 
    var numbers = s.split(' ').map((i)=>parseInt(i.trim()))
    return Math.min(...numbers) + ' ' + Math.max(...numbers);
}
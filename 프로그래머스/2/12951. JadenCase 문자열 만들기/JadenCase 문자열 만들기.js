function solution(s) {
    var answer = '';
    
    //s 문자열을 받아 옵니다.
    //"3people unFollowed me"
    // [3people, unFollowed
    //' '
    answer = s.split(' ').map((i)=>
                            i ? i[0].toUpperCase() + i.slice(1).toLowerCase()  : '' ).join(' ')
    
    return answer;
}
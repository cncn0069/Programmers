function solution(s) {
    var answer = '';
    
    const str = s.split(' ')
    
    for(st of str){
        let temp = st;
        
        if(temp.length > 0){
            temp = temp[0].toUpperCase() + temp.slice(1).toLowerCase()
        }
        answer = answer.concat(" ", temp);
    }
    
    return answer.trimStart();
}
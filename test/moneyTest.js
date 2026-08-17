import { formatCurrency } from "../scripts/utils/money.js";

console.log('test suite: format currency');
//testing test cases

//basic cases
console.log('converts cents to dollars');
if (formatCurrency(2095)==='20.95'){
    console.log('passed');
}
else{
    console.log('failed');
}


//edge cases
console.log('works with 0');
if(formatCurrency(0)==='0.00'){
     console.log('passed');
}
else{
    console.log('failed');
}

console.log('round up to nearest cent');
if(formatCurrency(2000.5)==='20.01'){
     console.log('passed');
}
else{
    console.log('failed');
}//if we hadnt used Math.round this would have failed
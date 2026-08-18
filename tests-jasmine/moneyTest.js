import {formatCurrency} from '../scripts/utils/money.js';


describe('test suite: formatCurrency',() =>{
     it('converts cents into dollars',()=>{
        expect(formatCurrency(2095)).toEqual('20.95');//it let us compare a value to another value
     });// it is used to create test in jasmine
});
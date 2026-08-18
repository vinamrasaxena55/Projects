import {formatCurrency} from '../../scripts/utils/money.js';


describe('test suite: formatCurrency',() =>{
     it('converts cents into dollars',()=>{
        expect(formatCurrency(2095)).toEqual('20.95');//it let us compare a value to another value
     });// it is used to create test in jasmine

       it('works with 0',()=>{
       expect(formatCurrency(0)),toEquals('0.00');
     });

     it('rounds up to the nearest cent',()=>{
       expect(formatCurrency(2000.5)),toEquals('20.01');
     });
});
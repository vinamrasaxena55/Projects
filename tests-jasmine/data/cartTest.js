import {addToCart,loadFromStorage,cart} from '../../data/cart.js';
//mock only last for 1 test
  describe('test suite: addToCart',()=>{
    it('adds an existing product to cart',()=>{
         spyOn(localStorage,'setItem');
       spyOn(localStorage,'getItem').and.callFake(()=>{
            return JSON.stringify([{
             productId: '15b6fc6f-327a-4ec4-896f-486349e85a3d',
             quantity:1,
             deliveryOptionId: '1'
        }]);
        });
        loadFromStorage();//loading cart from storage again


         addToCart('15b6fc6f-327a-4ec4-896f-486349e85a3d');
     expect(cart.length).toEqual(1);
     //when adding to cart cart length should be 1 on adding new element
     expect(localStorage.setItem).toHaveBeenCalledTimes(1);//to check if it is called
     expect(cart[0].productId).toEqual('15b6fc6f-327a-4ec4-896f-486349e85a3d');
     expect(cart[0].quantity).toEqual(2);
    });

//spyom records every time a method used
  //mocking local storage set item
   //spyon not directly under describe use it inside it 
     it('adds a new product to cart',()=>{
        spyOn(localStorage,'setItem');
        spyOn(localStorage,'getItem').and.callFake(()=>{
            return JSON.stringify([]);//making it empty
        });//spy on is mock function
        //or copy of function 
       

        loadFromStorage();//we make this as we made a fake function
        //so we need to load a empty cart bcz in orignal product 
        //the cart is not empty
     addToCart('15b6fc6f-327a-4ec4-896f-486349e85a3d');
     expect(cart.length).toEqual(1);
     //when adding to cart cart length should be 1 on adding new element
     expect(localStorage.setItem).toHaveBeenCalledTimes(1);//to check if it is called
     expect(cart[0].productId).toEqual('15b6fc6f-327a-4ec4-896f-486349e85a3d');
     expect(cart[0].quantity).toEqual(1);
    });
  });
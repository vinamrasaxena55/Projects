import {renderOrderSummary} from '../../scripts/checkout/orderSummary.js';
import {addToCart,loadFromStorage,cart} from '../../data/cart.js';
import { loadProducts,loadProductsFetch } from '../../data/products.js';
describe('test suite : renderOrderSummary',()=>{
   const productId1='e43638ce-6aa0-4b85-b27f-e1d07eb678c6';
         const productId2='15b6fc6f-327a-4ec4-896f-486349e85a3d';
   //creating a hook, hook let us run code for test
   //before each test it will run this

 beforeAll((done)=>{//done is fn provided by jasmine it do net let others run
  //wait till it is called,done allows us to control when to go to next step
  loadProductsFetch().then//returns a promise
  (()=>{
    done();//when load products finish then it let other run
  });
 

 });//runs this code before all other tests


   beforeEach(()=>{
      document.querySelector('.js-test-container')
      .innerHTML=`<div class="js-order-summary"></div>
      <div class="js-payment-summary"></div>
      `;
      //it put it inside the container we created in tests.html

        //below code bcz we load from local storage and it can cause prob 
        //so we do it as we need

       
       spyOn(localStorage,'getItem').and.callFake(()=>{
            return JSON.stringify([{
   productId: 'e43638ce-6aa0-4b85-b27f-e1d07eb678c6',
   quantity: 2,
   deliveryOptionId:'1'
},
{
  productId: '15b6fc6f-327a-4ec4-896f-486349e85a3d',
   quantity: 1,
   deliveryOptionId:'2'
}
  ]);
        });
        loadFromStorage();
        renderOrderSummary();
      });
        it('displays-cart',()=>{

      expect(document.querySelectorAll('.js-cart-item-contaioner-test').length).toEqual(2);
      //checking if added two items
     
     expect(document.querySelector(`.js-product-quantity-${productId1}`).innerText
    ).toContain('Quantity: 2');//check if we have this string in our code just text 
      expect(document.querySelector(`.js-product-quantity-${productId2}`).innerText
    ).toContain('Quantity: 1');  

  });

    document.querySelector('.js-test-container')
      .innerHTML='';//seeting as empty string to clean up Dom after test finish

  });
 
    //checking how page behaves
    it('removes a product',()=>{
   //mocking local storage as dont want changes in our main local storage
    spyOn(localStorage,'setItem');
   

        document.querySelector('.js-test-container')
      .innerHTML=`<div class="js-order-summary"></div>
      <div class="js-payment-summary"></div>
      `;
      

        const productId1='e43638ce-6aa0-4b85-b27f-e1d07eb678c6';
         const productId2='15b6fc6f-327a-4ec4-896f-486349e85a3d';
       spyOn(localStorage,'getItem').and.callFake(()=>{
            return JSON.stringify([{
   productId: 'e43638ce-6aa0-4b85-b27f-e1d07eb678c6',
   quantity: 2,
   deliveryOptionId:'1'
},
{
  productId: '15b6fc6f-327a-4ec4-896f-486349e85a3d',
   quantity: 1,
   deliveryOptionId:'2'
}
  ]);
        });
        loadFromStorage();

        renderOrderSummary();

   });



    it('display the cart',()=>{
     
        document.querySelector(`.js-delete-link-test-${productId1}`).click()
        ;
        expect(document.querySelectorAll('.js-cart-item-contaioner-test').length).toEqual(1);
        expect(document.querySelector(`.js-cart-item-container-${productId1}`)).toEqual(null);
        expect(document.querySelector(`.js-cart-item-container-${productId2}`)).not.toEqual(null);

        expect(cart.length).toEqual(1);
         expect(cart[0].productId).toEqual(productId2);


         
    document.querySelector('.js-test-container')
      .innerHTML='';//seeting as empty string to clean up Dom after test finish
    });

    

//when we check it doesnt load css 
//but gives a gist of page and specs of testing
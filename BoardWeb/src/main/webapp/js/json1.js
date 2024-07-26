/**
 * jaon1.js
 */

 document.querySelector('div.container-fluid>div:nth-of-type(2)').remove();
 document.querySelector('div.container-fluid>table').remove();
 
 // json 문자열
 // 자바스크립트 객체 {속성:값, 속성:값  여러개 가능} new Object();
 let obj = {name: '현모양철', age: 32, pets:[
	 {name: '행배', age: 1},
	 {name: '하랑', age: 3}
 	]
 } // -> {"name":"현모양철", "age":20} 문자열""묶어주기
 let json = JSON.stringify(obj) // -> 자바스크립트 객체를 문자열로 변환
 obj = JSON.parse(json) // -> 문자열을 자바스크립트 객체로 변환
 
 console.log
 
 
 
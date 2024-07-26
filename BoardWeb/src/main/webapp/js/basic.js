/**
 * basic.js
 */
 console.log("basic.js");
 
 //----------------------------------------------------------------------
let name = "링링";
let address = "중앙대로67길 11";
let age = 18;

// const myInfo = {name, address, age} // 속성과 벨류값이 같으면 줄여쓸수 있 다르면 name: name1 
const myInfoAry = [name, address, age];

// indax.jsp
// createElement('spam') 매개값에 만들고 싶은 요소 넣 => <span>/span>
// innerTaxt/innerHTML = 값
// 부모.appendChild(자식) => <부모><자식/></부모>
makeDom()
function makeDom(){
	
	//for in
	for(let prop of myInfoAry){
		let span = document.createElement('span');
		span.innerHTML = prop+', ';
		document.getElementById('show').appendChild(span);
		console.log(span);
	}
	// ↓ 를 ↑ 한번에 쓰는
	// // 이름을 담기 위한 코드
	//let span = document.createElement('span');
	//span.innerHTML = name + ', ';
	//document.getElementById('show').appendChild(span);
	//// 주소를 담기위한 코드
	//span = document.createElement('span');
	//span.innerHTML = address + ', ';
	//document.getElementById('show').appendChild(span);
	//console.log(span);
	//// 나이를 담기위한 코드
	//span = document.createElement('span');
	//span.innerHTML = age + ', ';
	//document.getElementById('show').appendChild(span);
	//console.log(span);
}


 console.log(`이름은 ${name}이고, 주소는 ${address}이다 ${age > 20 ? '성년' : '미성년자'}`);
 name = 20;
 console.log(typeof name); //데이터 타입보는법
 
 //----------------------------------------------------------------------
 
 const obj = {name:"김감치",
              age:33,
              myInto: function(){
								return this.name + ', ' + this.age;
								}
							}
							
console.log(`이름은 ${obj.name}, 나이는 ${obj.age}`)
console.log(obj.myInto());

//----------------------------------------------------------------------

for(let prop in obj) { // 객체안의 속성의 갯수만큼 반복 for in
	console.log(`속성은 ${prop}이고 값은 ${obj[prop]}`);
}

//----------------------------------------------------------------------

const ary = [1, 2, 3];
ary.push(4); // 배열 끝 추가
ary.unshift(5); // 배열 앞 추가

for(let num of ary){
	console.log(`값은 ${num}입니다`)
}

ary.forEach(function(item, idx, ary){ //자바스크립트에서 많이쓰는 반복문 [item=배열안의 값, idx=배열순번, ary=배열전체 기억요망]
	if(idx == 0 || idx == ary.length -1){
	console.log(item);
	}
});

const friends = [
	{name : "북조선", address : "개성공단", height : 170},
	{name : "김감치", address : "파판월드", height : 167},
	{name : "안예림", address : "능금마을", height : 160}
]
friends.forEach(function(friends){
	// friends정보를 한건씩 반복
	for(let prop in friends){
		console.log(prop + ', ' + friends[prop])
	}
	console.log('-----------------------------')
});
//----------------------------------------------------------------------










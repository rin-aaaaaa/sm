/**
 * json2.js
 */

document.querySelector('div.container-fluid>div:nth-of-type(2)').remove();
document.querySelector('div.container-fluid>table').remove();
 

 let json = `[{"id":1,"first_name":"Pearce","last_name":"Weerdenburg","email":"pweerdenburg0@cbslocal.com","gender":"Male","selery":9582},
{"id":2,"first_name":"Lek","last_name":"Robbings","email":"lrobbings1@berkeley.edu","gender":"Male","selery":1552},
{"id":3,"first_name":"Bathsheba","last_name":"Childs","email":"bchilds2@w3.org","gender":"Bigender","selery":6162},
{"id":4,"first_name":"Tiff","last_name":"Crumbleholme","email":"tcrumbleholme3@uiuc.edu","gender":"Female","selery":4329},
{"id":5,"first_name":"Winfred","last_name":"Crimes","email":"wcrimes4@xrea.com","gender":"Male","selery":7539},
{"id":6,"first_name":"Marlo","last_name":"Spong","email":"mspong5@is.gd","gender":"Male","selery":7834},
{"id":7,"first_name":"Lucho","last_name":"Hurren","email":"lhurren6@sogou.com","gender":"Male","selery":8360},
{"id":8,"first_name":"Neale","last_name":"Lindelof","email":"nlindelof7@biblegateway.com","gender":"Male","selery":5807},
{"id":9,"first_name":"Jesse","last_name":"Havercroft","email":"jhavercroft8@yolasite.com","gender":"Female","selery":6847},
{"id":10,"first_name":"Brit","last_name":"Showell","email":"bshowell9@hud.gov","gender":"Male","selery":1351},
{"id":11,"first_name":"Bendix","last_name":"Goom","email":"bgooma@about.me","gender":"Male","selery":1094},
{"id":12,"first_name":"Inglis","last_name":"Feldstern","email":"ifeldsternb@gizmodo.com","gender":"Male","selery":7895},
{"id":13,"first_name":"Cassandra","last_name":"Mandrey","email":"cmandreyc@chicagotribune.com","gender":"Female","selery":5746},
{"id":14,"first_name":"Brana","last_name":"Dainty","email":"bdaintyd@pbs.org","gender":"Female","selery":5628},
{"id":15,"first_name":"Cassi","last_name":"Brilon","email":"cbrilone@sciencedaily.com","gender":"Female","selery":5174},
{"id":16,"first_name":"Rhett","last_name":"Folini","email":"rfolinif@oaic.gov.au","gender":"Male","selery":308},
{"id":17,"first_name":"Violet","last_name":"Lovelock","email":"vlovelockg@alibaba.com","gender":"Female","selery":603},
{"id":18,"first_name":"Allyn","last_name":"Lytlle","email":"alytlleh@marriott.com","gender":"Female","selery":7382},
{"id":19,"first_name":"Floris","last_name":"Moraleda","email":"fmoraledai@naver.com","gender":"Female","selery":7325},
{"id":20,"first_name":"Darryl","last_name":"Funnell","email":"dfunnellj@slashdot.org","gender":"Male","selery":2012}]`;

let employees = JSON.parse(json);
console.log(employees);

document.querySelector('#searchGender').addEventListener('change', function(e){
	
})


function initList(){
	let target = document.getElementById('empList');
	target.innerHTML = '';
	let selValue = document.querySelector('#searchGender').value;
	employees.forEach(emp => {
		if(selValue == 'All' || emp.gendar == selValue){
			target.appendChild(makeRow(emp));
		}
	});
}

initList();



// 사원정보 => row 생성
function makeRow(emp = {}){
	let fields = ['id', 'first_name', 'last_name', 'salsry'];
	let tr = document.createElement('tr');
	fields.forEach(field => {
		let td = document.createElement('td');
		td.innerHTML = emp[field];
		tr.appendChild(td);
		
	})
	return tr;
}











/**
 board.js
*/
console.log('board.js' + bno);
let page = 1; // 아래쪽에서 댓글의 페이지를 지정(현재페이지를 받아놓는 변수)

// 댓글 등록 버튼에 클릭이벤트 등록
document.querySelector('#addReply').addEventListener('click', function() {
	let content = document.querySelector('#content').value;
	if (!replyer || !content) {
		alert('필수입력항목');
		return;
	}
	let parm = { bno, replyer, content }

	svc.addRelpy(parm, function() {
		// 등록완료 => 화면에 등록된 글 추가
		let result = JSON.parse(this.responseText);
		//console.log(result);
		if (result.retCode == 'Success') {
			//replyList.appendChild(makeRow(result.retVal));
			showPage();
			page=1;
		}
	});
});
// 댓글목록 출력
showPage();
function showPage(){
svc.replyList({ bno, page }, function() {
	// 기존 목록을 지우기
	replyList.querySelectorAll('li').forEach((li, idx) => {
	if (idx != 0) {
	li.remove();
 }
 })
	// 페이지 로드하면서 목록을 출력
	let result = JSON.parse(this.responseText);
	result.forEach(reply => {
		replyList.appendChild(makeRow(reply));
	});
	// 실제 데이터값으로 페이지 출력
	svc.pagingCount(bno, createPageList);
});
}

// reply => row 생성
function makeRow(reply = {}) { // reply = {} 객체타입 표시
	let cloned = document.querySelector('div.reply>div.content li').cloneNode(true);
	cloned.setAttribute('data-rno', reply.replyNo)
	cloned.style.display = 'block'; // <li style={}></li>
	cloned.querySelector('span:nth-of-type(1)').innerText = reply.replyNo;
	cloned.querySelector('span:nth-of-type(2)').innerText = reply.replyContent;
	cloned.querySelector('span:nth-of-type(3)').innerText = reply.replyer;
	cloned.querySelector('button').addEventListener('click', deleteReplyFnc)
	return cloned;
}

// 댓글 삭제 이벤트 핸들러
function deleteReplyFnc(e) {
	let rno = e.target.parentElement.parentElement.dataset.rno;
	svc.removeReply(rno, function(e) {
		let result = JSON.parse(this.responseText);
		if (result.retCode == 'Success') {
			alert('!!! 삭제 성공 !!!')
			//document.querySelector('li[data-rno="' + rno + '"]').remove();
			showPage()
		} else {
			alert('!!! 삭제 실패 !!!')
		}
	})
}


// 페이지 a태그 생성
function createPageList(event) {
	let result = JSON.parse(this.responseText);
	let totalCnt = result.totalCount;
	// page = 11;
	let startPage, endPage; // 현재페이지를 기준으로 계산한 첫 페이지 번호 ~ 마지막 페이지 번호
	let next, prev; // 이전, 이후 페이지를 체크하는 변수
	let realEnd = Math.ceil(totalCnt / 5); // 실제 마지막 페이지

	endPage = Math.ceil(page / 10) * 10;
	startPage = endPage - 9;
	endPage = endPage > realEnd ? realEnd : endPage;

	prev = startPage > 1; // 이전 10개의 페이지 존재를 구분
	next = endPage < realEnd ? true : false;

	document.querySelector('ul.pagination').innerHTML = ''; // 기존 html 지우기

	// 이전 10페이지 여부.
	let li = document.createElement('li');
	li.className = 'page-item'; // class='page-item active'
	// 이전페이지의 존재 구분
	if (prev) {
		let aTag = document.createElement('a');
		aTag.setAttribute('data-page', startPage-1)
		aTag.className = 'page-link';
		aTag.href = '#';
		aTag.innerHTML = 'Previous';
		li.appendChild(aTag);
	} else {
		li.classList.add('disabled'); // li요소의 클래스 추가
		//console.log(li)
		let span = document.createElement('span');
		span.className = 'page-link';
		span.innerHTML = 'Previous';
		li.appendChild(span);
	}
	document.querySelector('ul.pagination').appendChild(li);


	// 10개 출력.<li class="page-item"><a class="page-link" href="#">3</a></li>
	for (let p = startPage; p <= endPage; p++) {
		let li = document.createElement('li');
		li.className = 'page-item'; // class='page-item active'
		if (page == p) {
			li.classList.add('active');
			let span = document.createElement('span');
			span.className = 'page-link';
			span.innerHTML = p;
			li.appendChild(span);

		} else {
			let aTag = document.createElement('a');
			aTag.setAttribute('data-page', p)
			aTag.className = 'page-link';
			aTag.href = '#';
			aTag.innerHTML = p;
			li.appendChild(aTag);
		}
		document.querySelector('ul.pagination').appendChild(li);
	} // end do for

	// 이후 몇개의 페이지가 있는지
	li = document.createElement('li');
	li.className = 'page-item'; // class='page-item active'
	if (next) {
		let aTag = document.createElement('a');
		aTag.setAttribute('data-page', endPage+1)
		aTag.className = 'page-link';
		aTag.href = '#';
		aTag.innerHTML = 'next';
		li.appendChild(aTag);
	} else {
		li.classList.add('disabled'); // li태그 스타일을 비활성화
		let span = document.createElement('span');
		span.className = 'page-link';
		span.innerHTML = 'next';
		li.appendChild(span);
	}
	document.querySelector('ul.pagination').appendChild(li);

	// a태그의 이벤트 틍록
	pageMove();
} // end of createPageList


// paging영역의 a 태그를 클릭하면....
function pageMove() {
	document.querySelectorAll('div.reply ul.pagination a')//
		.forEach(item => {
			item.addEventListener('click', function(e) {
				page = item.dataset.page; // Previous, Next 
				// service에서 목록을 출력하는 메소드 호출
				showPage()
					// 실제 데이터값으로 페이지 출력
				}); // end of svc.replyList.
			}) // end of click event
} // end of pageMove


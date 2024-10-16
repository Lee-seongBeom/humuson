// 주문데이터 전역변수
let globalOrderList = {};

// 데이터 tr태그 append -s-
function appendTag(val){
    let orderTbody = $("#orderTbody");
    orderTbody.empty();     // 리스트 테이블 초기화
    globalOrderList = {};   // 전역변수 초기화

    // 데이터 없을 경우
    if(val == ""){
        orderTbody.append(`
            <tr>
                <td colspan="4">주문 목록이 없습니다</td>
            </tr>`);
    }

    val.forEach(e => {
        let row =`
            <tr>
                <td>${e.orderId}</td>
                <td>${e.orderName}</td>
                <td>${e.orderDate}</td>
                <td>${e.orderType}</td>
            </tr>`;

        orderTbody.append(row);
    });
    globalOrderList = val;
}
// 데이터 tr태그 append -e-

// 새로고침 -s-
function reloadBtn(){
    $.ajax({
        url: "./api/order/get",
        type: "GET",
        success: function(val) {
            appendTag(val);
            $("#searchText").val(""); // 주문ID 검색창 초기화
        },
        error: function(e) {
            alert("데이터를 불러오는 데 실패했습니다.");
        }
    })
}
// 새로고침 -e-

// 주문ID 검색 -s-
function searchId(e){

    // 엔터키만 허용 && 조회버튼 클릭
    if(e.keyCode != "13" && e != "13"){
        return false;
    }

    let searchText = $("#searchText").val();

    $.ajax({
        url: "./api/order/getSearchId",
        data: {
            id : searchText
        },
        type: "GET",
        success: function(val) {
            appendTag(val);
        },
        error: function(e) {
            alert("데이터를 불러오는 데 실패했습니다.");
        }
    });
}
// 주문ID 검색 -e-

// 외부시스템에 데이터 전송 -s-
function dateSend(){
    
    if (Object.keys(globalOrderList).length === 0) {
        alert("데이터가 없습니다. 데이터 추가 후 다시 실행해주세요.");
        return false;
    }else{
        $.ajax({
            url: "api/order/sendData",
            type: "POST",
            contentType: "application/json",
            data: JSON.stringify(globalOrderList),
            success: function() {
                alert("데이터 전송 완료");
            },
            error: function(e) {
                alert("데이터 전송 실패");
            }
        });
    }

}
// 외부시스템에 데이터 전송 -e-

// 리스트 형식으로 데이터 반환 -s-
function jsonToList(){

    if (Object.keys(globalOrderList).length === 0) {
        alert("데이터가 없습니다. 데이터 추가 후 다시 실행해주세요.");
        return false;
    }else{
        $.ajax({
            url: "api/order/jsonToList",
            type: "POST",
            contentType: "application/json",
            data: JSON.stringify(globalOrderList),
            success: function() {
                alert("데이터 전송 완료");
            },
            error: function(e) {
                alert("데이터 전송 실패");
            }
        });

    }

}
// 리스트 형식으로 데이터 반환 -e-
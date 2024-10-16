### 휴머스온 주문조회
---
접속 URL : http://localhost:8080/
- - -
#### 설명
- 버튼 설명
  * 새로고침 : 데이터를 갱신할때 사용
  * 주문조회 : 주문 ID를 이용해 데이터 검색 시 사용 ( input태그 엔터 사용 가능 )
  * 외부시스템으로 데이터 전송 : 조회된 데이터만 데이터 전송 ( 개발자도구 - Network - 네트워크 로그 중 'sendData' - Response 확인 )
  * 리스트 형식으로 데이터 반환 : 조회된 데이터만 데이터 반환 ( 개발자도구 - Network - 네트워크 로그 중 'jsonToList' - Response 확인 )



- 데이터 조회 설명
  * 데이터가 없을 시 '주문 목록이 없습니다' 표시
  * 새로고침시 검색 필터링 없는 메모리에 저장된 모든 데이터 표시
  * 주문 ID 조회 시 SQL - like 검색과 같은 기능으로 데이터 검색
- 테스트 방법
  * 외부 시스템에서 JSON 형식의 주문 데이터를 HTTP를 통해 받아와 내부 시스템에 저장할때
    > postman프로그램
    > 1. post방식으로 변경
    > 2. http://localhost:8080/api/order/add URL에 삽입
    > 3. Body탭 클릭, JSON타입으로 변경
    > 4. 더미데이터 삽입 후 Send 클릭
    > * 더미데이터
    > >  [
    {
        "orderId" : "ID1"
        ,"orderName" : "고객명1"
        ,"orderDate" : "2024-10-14"
        ,"orderType" : "처리중"
    },
    {
        "orderId" : "ID2"
        ,"orderName" : "고객명2"
        ,"orderDate" : "2024-10-15"
        ,"orderType" : "처리중"
    },
    {
        "orderId" : "ID3"
        ,"orderName" : "고객명3"
        ,"orderDate" : "2024-10-14"
        ,"orderType" : "완료"
    },
    {
        "orderId" : "ID4"
        ,"orderName" : "고객명4"
        ,"orderDate" : "2024-10-16"
        ,"orderType" : "처리중"
    },
    {
        "orderId" : "ID2"
        ,"orderName" : "고객명2"
        ,"orderDate" : "2024-10-15"
        ,"orderType" : "배송중"
    }
]

# 칸반보드 만들기 

## 1일차
<details>
    <summary>
        작업내용
</summary>
    1. 의존성 추가 <br>
    2. 톰캣 서버 셋팅 <br>
</details>

## 2일차

* 초기 설정
    - 데이터베이스 연결 설정 (mybatis)

* 레이아웃 구성
* 컨트롤러, 모델 뷰 구성하기(MVC)
    - 컨트롤러 구성
      - 회원쪽 컨트롤러
        - 회원가입 - /member/join
        - 로그인 - /member/login
        - 정보 수정 - /member/info
      - 작업관리 컨트롤러
        - 작업 목록 - /works
        - 작업 등록 - /works/add
        - 작업 조회 - /works/작업 번호 
        - 작업 수정 - /works/edit/등록번호
        - 작업 삭제 - /works/등록번호/delete
   
## 3일차
* 모델 구성 
* 뷰 구성
* 칸반 등록, 수정, 삭제, 조회
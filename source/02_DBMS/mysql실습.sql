-- DCL(계정 생성, 권한 부여, 권한 박탈, 계정 삭제)
-- DLL(제약 조건 FK, 시퀀스 없음 ㅠㅠ)
-- DML(OUTER JOIN, AND 연산자를 && 으로 사용해야함, OR 연산자는 || 으로 사용해야함,  
--    일부 단일행 함수 차이가 있음, ROWNUM이 없어서 TOP-N 구문이 다름)

-- Java에서 사용할 데이터를 넣어보고 연습해보기~ 
show databases;
 -- ★ ★ ★ DCL(계정 생성, 권한 부여, 권한 박탈, 계정 삭제)
 create user user01 identified by 'password'; -- 계정 생성
 grant all on *.* to user01; -- 권한부여
 revoke all on *.* from user01; -- 권한박탈alter
 drop user user01; -- 계정 삭제
 show databases;
 use world; -- world 데이터 베이스 영역으로 들어감
 show tables; -- 현재 들어와 있는 데이터 베이스 안의 테이블들
 create database dev_user;
 show databases;
 use dev_user;
 show tables;
 select database();
 
-- DLL(제약 조건 FK, 시퀀스 없음 ㅠㅠ)
 create table emp(
	empno numeric(4) primary key,
    ename varchar(6) not null,
    nickname varchar(6) unique,
    sal numeric(7,2) check(sal>0),
    comm numeric(7,2) default 0
    );
    
    desc emp;
    insert into emp (empno, ename, nickname, sal)
		values(1111, '김수한무거북', '두루미거북이', 20);
	select * from emp;
    drop table if exists emp;
    
    -- major : mCode(학과번호, 인위적pk), 
    create table major(
		mCode int primary key auto_increment, -- 자동 증가 되는 pk(int형)
        mName varchar(10),
        mOffice varchar(30)
    );
    create table student(
		sNo numeric(4) primary key,
        sName varchar(10),
        mCode int, 
        foreign key(mCode) references major(mCode)
    ); -- 외래키 제약조건은 꼭 아래에 작성
    
    insert into major (mName, mOffice) 
		values ('컴공', '201호'); -- ctrl + D 복사 명령어
	insert into major (mName, mOffice)      
		values ('컴공', '201호'); -- ctrl + D 복사 명령어
    insert into major (mName, mOffice) 
		values ('웹디', '203호');
        
	select * from major;
    
	insert into student 
		values (1001, '홍길동', 1);
	insert into student 
		values (1002, '신길동', 2);
	insert into student 
		values (1011, '박길동', 4);
    
    select * from student;
    
    drop table if exists major;
    drop table if exists student;
    
    
    -- 학번, 이름, 학과번호, 학과명, 학과사무실
    select sno, sname, m.mcode, mname, moffice
		from student s, major m
        where s.mcode=m.mcode;
        
	-- 학번, 이름, 학과번호, 학과명, 학과사무실( 학새잉 없는 학과도 출력) -outer join 
     select sno, sname, m.mcode, mname, moffice
		from student s right outer join major m -- outer join 문법
        on s.mcode=m.mcode;
        
	-- ★ ★ ★ ★ ★ 자바(jdbc) 수업시간에 사용할 테이블
    drop table if exists personal; -- emp 테이블 유사
    drop table if exists division; -- dept테이블 유사
    
    create table division (
		dno int, -- 부서번호
        dname varchar(20) not null, -- 부서명
        phone varchar(20) unique, -- 부서 전화
        position varchar(20), -- 부서 위치
        primary key(dno)
    );
    insert into division values (10, 'finance', '02-888-8888', '신림');
    insert into division values (20, 'research', '02-777-8888', '용산');
    insert into division values (30, 'sales', '02-666-8888', '강서');
    insert into division values (40, 'cs', '02-555-8888', '강남');
	
    select * from division;
    
    create table personal (
		pno int, -- 사번
        pname varchar(20) not null, -- 사원명
        job varchar(20) not null, -- 직책
        manager int, -- 상사 사번
        startdate date, -- 입사일
        pay int, -- 급여
        bonus int, -- 상여금
        dno int, -- 부서번호
        primary key(pno),
        foreign key(dno) references division(dno)
    );
    insert into personal values (1111,'smith','manager', 1001, '1990-12-17', 1000, null, 10);
	insert into personal values (1112,'ally','salesman',1116,'1991-02-20',1600,500,30);
	insert into personal values (1113,'word','salesman',1116,'1992-02-24',1450,300,30);
	insert into personal values (1114,'james','manager',1001,'1990-04-12',3975,null,20);
	insert into personal values (1001,'bill','president',null,'1989-01-10',7000,null,10);
	insert into personal values (1116,'johnson','manager',1001,'1991-05-01',3550,null,30);
	insert into personal values (1118,'martin','analyst',1111,'1991-09-09',3450,null,10);
	insert into personal values (1121,'kim','clerk',1114,'1990-12-08',4000,null,20);
	insert into personal values (1123,'lee','salesman',1116,'1991-09-23',1200,0,30);
	insert into personal values (1226,'park','analyst',1111,'1990-01-03',2500,null,10);
    select pno "no", pname, pay, bonus, pay+ifnull(bonus, 0) sum from personal;
    select pname, pay+if(bonus is null, 0, bonus) sum from personal;
    
    
-- 1. 사번, 이름, 급여를 출력
select pno, pname, pay
	from personal;
-- 2. 급여가 2000~5000 사이 모든 직원의 모든 필드
select *
	from personal
    where pay between 2000 and 5000;
-- 3. 부서번호가 10또는 20인 사원의 사번, 이름, 부서번호
select pno, pname, d.dno
	from personal p, division d
    where p.dno = d.dno
    and d.dno like '%20%';
-- 4. 보너스가 null인 사원의 사번, 이름, 급여 급여 큰 순정렬
select pno, pname, pay
	from personal
    where bonus is null
    order by pay desc;
-- 5. 사번, 이름, 부서번호, 급여. 부서코드 순 정렬 같으면 PAY 큰순
select pno, pname, d.dno, pay
	from personal p, division d
    where p.dno = d.dno
    order by d.dno, pay;
-- 6. 사번, 이름, 부서명
select pno, pname, dno
	from personal;
-- 7. 사번, 이름, 상사이름
select p.pno, p.pname, m.pname AS manager_name
	from personal p, personal m
	where p.manager = m.pno;
-- 8. 사번, 이름, 상사이름(상사가 없는 사람도 출력하되 상사가 없는 경우 ★CEO★로 출력) – 우선
select p.pno "사번", p.pname "이름", ifnull(m.pname, "CEO") "CEO"
	from personal p right outer join personal m
	on p.manager = m.pno;
-- 9. 이름이 s로 시작하는 사원 이름 (like 이용, substr함수이용, instr함수 이용등 다양하게 사용 가능)
select pname
	from personal
    where pname like 's%';
-- 10. 사번, 이름, 급여, 부서명, 상사이름
select distinct p.pno, p.pname, p.pay, d.dname, m.pname
	from personal p, personal m, division d
	where p.manager = m.pno;
-- 11. 부서코드, 급여합계, 최대급여
select d.dno, sum(pay), max(pay)
	from personal p, division d
    where p.dno = d.dno
    group by d.dno;
-- 12. 부서명, 급여평균, 인원수
select d.dname, avg(pay), count(d.dno)
	from personal p, division d
    where p.dno = d.dno
    group by d.dname;    
-- 13. 부서코드, 급여합계, 인원수 인원수가 4명 이상인 부서만 출력
select d.dno, avg(pay), count(d.dno)
	from personal p, division d
    where p.dno = d.dno
    group by d.dno
    having count(d.dno) >= 4; 
-- 14. 사번, 이름, 급여 회사에서 제일 급여를 많이 받는 사람
select pno, pname, pay
	from personal
    where pay = (select max(pay)
					from personal);
-- 15. 회사 평균보다 급여를 많이 받는 사람 이름, 급여, 부서번호
select * from personal;

select avg(pay)
	from personal;

select pname, pay, dno
	from personal
    where pay >= (select avg(pay)
					from personal);
-- 16. 회사 평균 급여보다 많이 받는 사원의 사번, 이름, 급여, 부서명을 출력(부서명순 정열 같으면 급여 큰순 정렬)
select pno, pname, pay, dname
	from personal p, division d
    where p.dno = d.dno 
    and pay >= (select avg(pay)
					from personal)
order by dname, pay desc;

select * from personal;
-- 17. 자신이 속한 부서의 평균보다 많인 받는 사람의 이름, 급여, 부서번호, 반올림한 해당부서평균 (where절의 subQuery를 이용하거나 inline view를 이용)
select dno, round(avg(pay) , 0) as "평균 급여"
	from personal
    group by dno;

select pname, pay, p.dno, avgpay
	from personal p, (select dno, round(avg(pay), 0) "평균 급여"
						from personal
						group by dno) a
	where p.dno = a.dno
    and pay >= a."평균 급여";  

-- 18. 입사가 가장 빠른 사람의 이름, 급여, 부서명
 
-- 19. 이름, 급여, 해당부서평균(select절의 subQuery를 이용하거나 inline view를 이용)

-- 20. 이름, 급여, 부서명, 해당부서평균(select절의 subQuery를 이용하거나 inline view를 이용)

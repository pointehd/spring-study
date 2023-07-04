### 트랜잭션 전파레벨

- `Propagation.REQUIRES_NEW`
> 전파 레벨을 REQUIRES_NEW 로 할경우 새로운 트랜잭션에서 에러가 발생할 경우 부모 트랜잭션도 롤백된다.   
> REQUIRES_NEW 의 트랜잭션이 끝나고 부모트랜잭션에서 에러가 발생할 경우 부모트랜잭션만 롤백된다.
> 

### `EventListener`



### `@TransactionEventListener`
> AFTER_COMMIT 에러 발생시  debug level 로 로그를 찍는다.    
> 커밋 결과에 영향을 받지 않아 정상적으로 작동한다.
> [참고](https://lenditkr.github.io/spring/transactional-event-listener/index.html)

### 비동기 처리 `@Async`

- 비동기 처리로 할경우 
> 메인 스레드에서 에러가 발생할 경우 비동기 프로그램은 정상 작동한다.    
> 비동기 스레드에서 에러가 발생할 경우 메인 스레드는 정상 작동한다. 
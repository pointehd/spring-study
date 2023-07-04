### 트랜잭션 전파레벨

- `Propagation.REQUIRES_NEW`
> 전파 레벨을 REQUIRES_NEW 로 할경우 새로운 트랜잭션에서 에러가 발생할 경우 부모 트랜잭션도 롤백된다.   
> REQUIRES_NEW 의 트랜잭션이 끝나고 부모트랜잭션에서 에러가 발생할 경우 부모트랜잭션만 롤백된다.
> 

### `EventListener`



### `@TransactionEventListener`


### 비동기 처리 `@Async`

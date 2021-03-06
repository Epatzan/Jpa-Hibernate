package com.katariasoft.technologies.jpaHibernate.entity.concurrency.locking.pessimistic;

import java.util.Optional;

import javax.persistence.LockModeType;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PessimisticLockTests extends PessimisticLockTestSupport {

	@Test
	@Rollback(false)
	public void pessimisticReadSimpleReadTest1() {
		testPessimisticLocking(40, Optional.empty(), Optional.empty(), 50000L, 50000L);
	}

	@Test
	@Rollback(false)
	public void pessimisticReadSimpleReadTest() {
		testPessimisticLocking(5, Optional.of(LockModeType.PESSIMISTIC_READ), Optional.empty());
	}

	@Test
	@Rollback(false)
	public void pessimisticReadPessimisticReadTest() {
		testPessimisticLocking(15, Optional.of(LockModeType.PESSIMISTIC_READ),
				Optional.of(LockModeType.PESSIMISTIC_READ));
	}

	// unclear
	@Test
	@Rollback(false)
	public void pessimisticReadPessimisticWriteTest() {
		testPessimisticLocking(31, Optional.of(LockModeType.PESSIMISTIC_READ),
				Optional.of(LockModeType.PESSIMISTIC_WRITE));
	}

	// unclear
	@Test
	@Rollback(false)
	public void pessimisticWriteSimpleReadTest() {
		testPessimisticLocking(32, Optional.of(LockModeType.PESSIMISTIC_WRITE), Optional.empty());
	}

	@Test
	@Rollback(false)
	public void pessimisticWritePessimisticReadTest() {
		testPessimisticLocking(20, Optional.of(LockModeType.PESSIMISTIC_WRITE),
				Optional.of(LockModeType.PESSIMISTIC_READ));
	}

	@Test
	@Rollback(false)
	public void pessimisticWritePessimisticWriteTest() {
		testPessimisticLocking(6, Optional.of(LockModeType.PESSIMISTIC_WRITE),
				Optional.of(LockModeType.PESSIMISTIC_WRITE));
	}

}

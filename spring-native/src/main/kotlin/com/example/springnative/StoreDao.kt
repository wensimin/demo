package com.example.springnative

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.JpaSpecificationExecutor

interface StoreDao : JpaRepository<Store, Long>, JpaSpecificationExecutor<Store>
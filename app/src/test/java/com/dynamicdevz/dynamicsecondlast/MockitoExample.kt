package com.dynamicdevz.dynamicsecondlast

import junit.framework.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Answers
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations
class MockitoExample {

    private val engine = "1988 Engine 101"

    @JvmField
    @Mock
    var i8: Car? = null

     /*
     * @Mock
     * lateinit var view: View
     *
     * */

    @Before
    fun setUp(){

        MockitoAnnotations.initMocks(this)
        //val presenter = Presenter(view)
    }

    @Test
    fun testCarEngineModel() {
        Mockito.`when`(i8?.getModel()).thenReturn(engine)
        assertEquals(i8?.getModel(), engine)
    }



}
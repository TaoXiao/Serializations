package cn.gridx.serializations.kryo.serializer

import org.apache.hadoop.hbase.util.Bytes

/**
 * Created by tao on 7/16/15.
 */
class Student(val name:String, val bytes:Array[Byte]) {
    val homeDir = System.getProperty("user.home")

    val timestamp = System.currentTimeMillis

    override
    def toString() = s"Name = $name, bytes = ${Bytes.toString(bytes)}, homeDir = ${homeDir}, timestamp = ${timestamp}"

    //println("start constructing!")

    //println(toString)

    //println("finish constructing!")
}

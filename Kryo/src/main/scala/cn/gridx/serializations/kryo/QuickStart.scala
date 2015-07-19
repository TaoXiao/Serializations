package cn.gridx.serializations.kryo

import java.io.{FileInputStream, FileOutputStream}

import com.esotericsoftware.kryo.Kryo
import com.esotericsoftware.kryo.io.{Input, Output}
import org.apache.hadoop.hbase.io.ImmutableBytesWritable
import org.apache.hadoop.hbase.util.Bytes

/**
 * Created by tao on 7/16/15.
 */
object QuickStart {
    def main(args: Array[String]): Unit = {
        val obj = new ImmutableBytesWritable(Bytes.toBytes("Test ImmutableBytesWritable"))

        serialize(obj, "a.dat")
        deserialize("a.dat")
    }

    def serialize(obj: ImmutableBytesWritable, path:String): Unit = {
        val kryo = new Kryo()
        val output = new Output(new FileOutputStream(path))
        kryo.writeObject(output, obj)
        output.close
    }


    def deserialize(path: String): Unit = {
        val kryo = new Kryo()
        val input = new Input(new FileInputStream(path))
        val obj = kryo.readObject(input, classOf[ImmutableBytesWritable])
                .asInstanceOf[ImmutableBytesWritable]

        println(Bytes.toStringBinary(obj.get))
        input.close
    }
}

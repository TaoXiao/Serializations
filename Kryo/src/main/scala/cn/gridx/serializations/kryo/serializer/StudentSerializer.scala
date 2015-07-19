package cn.gridx.serializations.kryo.serializer

import com.esotericsoftware.kryo.io.{Output, Input}
import com.esotericsoftware.kryo.{Kryo, Serializer}

/**
 * Created by tao on 7/16/15.
 */
object StudentSerializer extends Serializer[Student] {
    def write(kryo: Kryo, output: Output, t: Student): Unit = {
        output.writeString(t.name)
        output.writeInt(t.bytes.length)
        output.writeBytes(t.bytes)
    }

    def read(kryo: Kryo, input: Input, aClass: Class[Student]): Student = {
        new Student(input.readString, input.readBytes(input.readInt))
    }
}

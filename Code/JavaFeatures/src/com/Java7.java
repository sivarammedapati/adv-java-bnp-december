package com;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.Channel;
import java.nio.channels.FileChannel;
import java.nio.channels.FileChannel.MapMode;

public class Java7 {

	
	public Java7() {
		System.out.println("Java7.Java7()");

	}
	
	public static void main(String[] args) {
		
		//withoutBuffer();
		//withBuffer();
		//withChannels();
		memoryMapped();
	}
	
	private static void memoryMapped() {
		
		try(RandomAccessFile file = new RandomAccessFile("C:\\temp\\test.pdf", "r")) {
			
			FileChannel channel = file.getChannel();
			
			MappedByteBuffer buffer = channel.map(MapMode.READ_ONLY, 100000, file.length()-200000);
			
			System.out.println(buffer.capacity());
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	private static void withChannels() {
		try(FileInputStream fis = new FileInputStream("C:\\temp\\test.pdf"); 
									FileOutputStream fos = new FileOutputStream("C:\\temp\\copy.pdf")){
			
			FileChannel inputChannel = fis.getChannel();
			FileChannel outputChannel = fos.getChannel();
			
			//ByteBuffer buffer = ByteBuffer.allocate(1024 * 16 * 16);
			ByteBuffer buffer = ByteBuffer.allocateDirect(1024 * 16 * 16);
			
			//int ch = 0;
			long startTime = System.currentTimeMillis(); 
			while(true) {
				int ch = inputChannel.read(buffer);
				
				if(ch == -1) break;
				
				buffer.flip();
				
				outputChannel.write(buffer);
				buffer.clear();
			}
			long endTime = System.currentTimeMillis(); 
			System.out.println("Time taken: " + (endTime - startTime));
			
		}catch(Exception ex ) {
			ex.printStackTrace();
		}
	}
	

	private static void withBuffer() {
		try(FileInputStream fis = new FileInputStream("C:\\temp\\test.pdf"); 
									FileOutputStream fos = new FileOutputStream("C:\\temp\\copy.pdf")){
			
			BufferedInputStream inputBuffer = new BufferedInputStream(fis);
			BufferedOutputStream outputBuffer = new BufferedOutputStream(fos);
			
			int ch = 0;
			long startTime = System.currentTimeMillis(); 
			while(true) {
				ch = inputBuffer.read();
				if(ch == -1) break;
				
				outputBuffer.write(ch);
			}
			long endTime = System.currentTimeMillis(); 
			System.out.println("Time taken: " + (endTime - startTime));
			
		}catch(Exception ex ) {
			ex.printStackTrace();
		}
	}
	
	private static void withoutBuffer() {
		try(FileInputStream fis = new FileInputStream("C:\\temp\\test.pdf"); 
									FileOutputStream fos = new FileOutputStream("C:\\temp\\copy.pdf")){
			
			int ch = 0;
			long startTime = System.currentTimeMillis(); 
			while(true) {
				ch = fis.read();
				if(ch == -1) break;
				
				fos.write(ch);
			}
			long endTime = System.currentTimeMillis(); 
			System.out.println("Time taken: " + (endTime - startTime));
			
		}catch(Exception ex ) {
			ex.printStackTrace();
		}
	}

}

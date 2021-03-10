package queue;

import linkedlist.SingleLinkedList;

public class QueueByLinkedlist {
	private SingleLinkedList list;

	public QueueByLinkedlist() {
		list = new SingleLinkedList();
	}

	public void enQueue(int value) {
		if (list.getHead() == null) {
			list.createSingleLinkedList(value);
		} else {
			list.insertIntoLinkedList(value, list.getSize());
		}
	}

	public int deQueue() {
		int value = Integer.MIN_VALUE;
		if (list.existsLinkedList()) {
			value = list.getHead().getValue();
			list.deleteNode(0);
			return value;
		} else {
			throw new RuntimeException("Queue is empty !!");
		}
	}

	public int peek() {
		if (isQueueEmpty()) {
			throw new RuntimeException("Queue is empty !!!");
		} else {
			return list.getHead().getValue();
		}
	}

	public boolean isQueueEmpty() {
		if (list.getHead() != null) {
			return false;
		}
		return true;
	}

	public void delete() {
		list.setHead(null);
	}
	
	public void printQueue()
	{
		list.traverseLinkedList();
	}
}
